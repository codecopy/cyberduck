package ch.cyberduck.core.s3;

import ch.cyberduck.core.AbstractTestCase;
import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.DisabledHostKeyCallback;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.DisabledTranscriptListener;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.TestProtocol;

import org.junit.Test;

import java.util.EnumSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @version $Id$
 */
public class S3BucketListServiceTest extends AbstractTestCase {

    @Test
    public void testGetContainer() throws Exception {
        assertEquals("bucketname", new S3BucketListService(new S3Session(new Host(new S3Protocol()))).getContainer(new Host(new S3Protocol(), "bucketname.s3.amazonaws.com")));
        assertEquals(null, new S3BucketListService(new S3Session(new Host(new S3Protocol()))).getContainer(new Host(new TestProtocol(), "bucketname.s3.amazonaws.com")));
    }

    @Test
    public void testList() throws Exception {
        final S3Session session = new S3Session(
                new Host(new S3Protocol(), new S3Protocol().getDefaultHostname(),
                        new Credentials(
                                properties.getProperty("s3.key"), properties.getProperty("s3.secret")
                        )));
        session.open(new DisabledHostKeyCallback(), new DisabledTranscriptListener());
        final List<Path> list = new S3BucketListService(session).list(new DisabledListProgressListener());
        assertFalse(list.isEmpty());
        assertTrue(list.contains(new Path("test.cyberduck.ch", EnumSet.of(Path.Type.directory, Path.Type.volume))));
        session.close();
    }

    @Test
    public void testListWithRootDefaultPath() throws Exception {
        final S3Session session = new S3Session(
                new Host(new S3Protocol(), new S3Protocol().getDefaultHostname(), 443, "/",
                        new Credentials(
                                properties.getProperty("s3.key"), properties.getProperty("s3.secret")
                        )));
        session.open(new DisabledHostKeyCallback(), new DisabledTranscriptListener());
        final List<Path> list = new S3BucketListService(session).list(new DisabledListProgressListener());
        assertFalse(list.isEmpty());
        assertTrue(list.contains(new Path("test.cyberduck.ch", EnumSet.of(Path.Type.directory, Path.Type.volume))));
        session.close();
    }

    @Test
    public void testListRestrictRegion() throws Exception {
        final S3Session session = new S3Session(
                new Host(new S3Protocol(), new S3Protocol().getDefaultHostname(),
                        new Credentials(
                                properties.getProperty("s3.key"), properties.getProperty("s3.secret")
                        )));
        session.open(new DisabledHostKeyCallback(), new DisabledTranscriptListener());
        final List<Path> list = new S3BucketListService(session, new S3LocationFeature.S3Region("eu-central-1"))
                .list(new DisabledListProgressListener());
        assertFalse(list.isEmpty());
        for(Path bucket : list) {
            assertEquals("eu-central-1", bucket.attributes().getRegion());
        }
        session.close();
    }
}