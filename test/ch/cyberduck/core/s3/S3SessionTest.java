package ch.cyberduck.core.s3;

import ch.cyberduck.core.*;
import ch.cyberduck.core.analytics.AnalyticsProvider;
import ch.cyberduck.core.features.Encryption;
import ch.cyberduck.core.features.Lifecycle;
import ch.cyberduck.core.features.Location;
import ch.cyberduck.core.features.Logging;
import ch.cyberduck.core.features.Redundancy;
import ch.cyberduck.core.features.Versioning;
import ch.cyberduck.core.identity.IdentityConfiguration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version $Id$
 */
public class S3SessionTest extends AbstractTestCase {

    @Test
    public void testFile() {
        final S3Session session = new S3Session(new Host(Protocol.S3_SSL, "h"));
        assertFalse(session.isCreateFileSupported(new Path("/", Path.VOLUME_TYPE)));
        assertTrue(session.isCreateFileSupported(new Path(new Path("/", Path.VOLUME_TYPE), "/container", Path.VOLUME_TYPE)));
    }

    @Test
    public void testConnect() throws Exception {
        final Host host = new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname(), new Credentials(
                properties.getProperty("s3.key"), properties.getProperty("s3.secret")
        ));
        final S3Session session = new S3Session(host);
        assertNotNull(session.open(new DefaultHostKeyController()));
        assertTrue(session.isConnected());
        assertNotNull(session.getClient());
        session.login(new DisabledPasswordStore(), new DisabledLoginController());
        assertNotNull(session.mount());
        assertFalse(session.cache().isEmpty());
        assertTrue(session.cache().containsKey(new Path("/", Path.DIRECTORY_TYPE | Path.VOLUME_TYPE).getReference()));
        assertNotNull(session.cache().lookup(new Path("/test.cyberduck.ch", Path.DIRECTORY_TYPE | Path.VOLUME_TYPE).getReference()));
        assertTrue(session.isConnected());
        session.close();
        assertFalse(session.isConnected());
        assertEquals(Session.State.closed, session.getState());
        session.open(new DefaultHostKeyController());
        assertTrue(session.isConnected());
        assertNotNull(session.mount());
        session.close();
        assertFalse(session.isConnected());
    }

    @Test
    public void testConnectCnameAnonymous() throws Exception {
        final Host host = new Host(Protocol.S3_SSL, "dist.springframework.org", new Credentials(
                Preferences.instance().getProperty("connection.login.anon.name"), null
        ));
        final S3Session session = new S3Session(host);
        assertNotNull(session.open(new DefaultHostKeyController()));
        assertTrue(session.isConnected());
        assertNotNull(session.getClient());
        session.login(new DisabledPasswordStore(), new DisabledLoginController());
        assertNotNull(session.mount());
        assertTrue(session.isConnected());
        session.close();
        assertFalse(session.isConnected());
        assertEquals(Session.State.closed, session.getState());
    }


    @Test
    public void testConnectBuckenameAnonymous() throws Exception {
        final Host host = new Host(Protocol.S3_SSL, "dist.springframework.org.s3.amazonaws.com", new Credentials(
                Preferences.instance().getProperty("connection.login.anon.name"), null
        ));
        final S3Session session = new S3Session(host);
        assertNotNull(session.open(new DefaultHostKeyController()));
        assertTrue(session.isConnected());
        assertNotNull(session.getClient());
        session.login(new DisabledPasswordStore(), new DisabledLoginController());
        assertNotNull(session.mount());
        assertTrue(session.isConnected());
        session.close();
        assertFalse(session.isConnected());
        assertEquals(Session.State.closed, session.getState());
    }

    @Test
    public void testFeatures() throws Exception {
        final S3Session aws = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname()));
        assertNotNull(aws.getFeature(Versioning.class, null));
        assertNotNull(aws.getFeature(AnalyticsProvider.class, null));
        assertNotNull(aws.getFeature(Lifecycle.class, null));
        assertNotNull(aws.getFeature(Location.class, null));
        assertNotNull(aws.getFeature(Encryption.class, null));
        assertNotNull(aws.getFeature(Redundancy.class, null));
        assertNotNull(aws.getFeature(Logging.class, null));
//        assertNotNull(aws.getFeature(DistributionConfiguration.class, null));
        assertNotNull(aws.getFeature(IdentityConfiguration.class, null));
        final S3Session o = new S3Session(new Host(Protocol.S3_SSL, "o"));
        assertNull(o.getFeature(Versioning.class, null));
        assertNull(o.getFeature(AnalyticsProvider.class, null));
        assertNull(o.getFeature(Lifecycle.class, null));
        assertNull(o.getFeature(Location.class, null));
        assertNull(o.getFeature(Encryption.class, null));
        assertNull(o.getFeature(Redundancy.class, null));
        assertNull(o.getFeature(Logging.class, null));
//        assertNotNull(o.getFeature(DistributionConfiguration.class, null));
        assertNull(o.getFeature(IdentityConfiguration.class, null));
    }

    @Test
    public void testUri() throws Exception {
        final S3Session session = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname()));
        assertEquals("https://test.cyberduck.ch.s3.amazonaws.com/key",
                session.toURL(new Path("/test.cyberduck.ch/key", Path.FILE_TYPE)));
    }

    @Test
    public void testHttpUri() throws Exception {
        final S3Session aws = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname()));
        assertEquals("http://test.cyberduck.ch.s3.amazonaws.com/key", aws.toHttpURL(new Path("/test.cyberduck.ch/key", Path.FILE_TYPE)));
    }

    @Test
    public void testToSignedUrlNoKey() throws Exception {
        final S3Session session = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname(),
                new Credentials("anonymous", null)));
        assertEquals(new DescriptiveUrl(null, ""), session.toSignedUrl(new Path("/test.cyberduck.ch/test", Path.FILE_TYPE)));
    }

    @Test
    public void testToSignedUrl() throws Exception {
        final S3Session session = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname(), new Credentials(
                properties.getProperty("s3.key"), properties.getProperty("s3.secret")
        )));
        assertTrue(
                session.toSignedUrl(new Path("/test.cyberduck.ch/test", Path.FILE_TYPE)).getUrl().startsWith(
                        "https://test.cyberduck.ch.s3.amazonaws.com/test?AWSAccessKeyId=AKIAIUTN5UDAA36D3RLQ&Expires="
                ));
    }

    @Test
    public void createTorrentUrl() throws Exception {
        final S3Session session = new S3Session(new Host(Protocol.S3_SSL, Protocol.S3_SSL.getDefaultHostname(),
                new Credentials("anonymous", null)));
        assertEquals(new DescriptiveUrl("http://test.cyberduck.ch.s3.amazonaws.com/test?torrent"),
                session.toTorrentUrl(new Path("/test.cyberduck.ch/test", Path.FILE_TYPE)));
    }
}
