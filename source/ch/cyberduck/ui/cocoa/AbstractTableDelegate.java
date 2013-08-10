package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2005 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import ch.cyberduck.core.NullComparator;
import ch.cyberduck.core.Preferences;
import ch.cyberduck.ui.cocoa.application.NSEvent;
import ch.cyberduck.ui.cocoa.application.NSOutlineView;
import ch.cyberduck.ui.cocoa.application.NSTableColumn;
import ch.cyberduck.ui.cocoa.application.NSTableView;
import ch.cyberduck.ui.cocoa.foundation.NSNotification;
import ch.cyberduck.ui.cocoa.foundation.NSObject;

import org.rococoa.ID;
import org.rococoa.cocoa.foundation.NSInteger;

import java.util.Comparator;

/**
 * @version $Id$
 */
public abstract class AbstractTableDelegate<E> extends ProxyController implements TableDelegate<E> {

    private NSTableColumn selectedColumn;

    protected AbstractTableDelegate(final NSTableColumn selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    protected void setSelectedColumn(NSTableColumn selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    /**
     * @return The identifier of the column selected or null
     */
    protected String selectedColumnIdentifier() {
        // Return previously set custom sorting preference
        return this.selectedColumn.identifier();
    }

    /**
     * @return By default no column is editable. To be overriden in subclasses
     */
    public boolean isColumnRowEditable(NSTableColumn column, int row) {
        return false;
    }

    /**
     * @see NSTableView.DataSource
     */
    public boolean tableView_shouldSelectRow(NSTableView view, NSInteger row) {
        return true;
    }

    /**
     * @see NSTableView.DataSource
     */
    public boolean outlineView_shouldSelectItem(NSOutlineView view, NSObject item) {
        return true;
    }

    /**
     * @see NSTableView.DataSource
     */
    public boolean tableView_shouldEditTableColumn_row(NSTableView view, NSTableColumn c, NSInteger row) {
        return this.isColumnRowEditable(c, row.intValue());
    }

    /**
     * @see NSTableView.DataSource
     */
    public boolean outlineView_shouldEditTableColumn_item(NSOutlineView view, NSTableColumn c, NSObject item) {
        return this.isColumnRowEditable(c, -1);
    }

    public boolean selectionShouldChange() {
        return true;
    }

    /**
     * @see NSTableView.DataSource
     */
    public boolean selectionShouldChangeInTableView(NSTableView view) {
        return this.selectionShouldChange();
    }

    /**
     * @see NSOutlineView.DataSource
     */
    public boolean selectionShouldChangeInOutlineView(NSTableView view) {
        return this.selectionShouldChange();
    }

    public abstract void tableColumnClicked(NSTableView view, NSTableColumn tableColumn);

    /**
     * @see NSOutlineView.Delegate
     */
    public void outlineView_didClickTableColumn(NSOutlineView view, NSTableColumn tableColumn) {
        this.tableColumnClicked(view, tableColumn);
    }

    /**
     * @see NSTableView.Delegate
     */
    public void tableView_didClickTableColumn(NSOutlineView view, NSTableColumn tableColumn) {
        this.tableColumnClicked(view, tableColumn);
    }

    public abstract void tableRowDoubleClicked(final ID sender);

    public void tableViewSelectionDidChange(NSNotification notification) {
        this.selectionDidChange(notification);
    }

    public void tableViewSelectionIsChanging(NSNotification notification) {
        this.selectionIsChanging(notification);
    }

    public void outlineViewSelectionDidChange(NSNotification notification) {
        this.selectionDidChange(notification);
    }

    public void outlineViewSelectionIsChanging(NSNotification notification) {
        this.selectionIsChanging(notification);
    }

    public abstract void selectionDidChange(NSNotification notification);

    public void selectionIsChanging(NSNotification notification) {
        //
    }

    // ----------------------------------------------------------
    // Sorting
    // ----------------------------------------------------------

    @Override
    public Comparator<E> getSortingComparator() {
        return new NullComparator<E>();
    }

    private Boolean sortAscending;

    public void setSortedAscending(boolean sortAscending) {
        //cache custom sorting preference
        this.sortAscending = sortAscending;
        //set default value
        Preferences.instance().setProperty("browser.sort.ascending", this.sortAscending);
    }

    @Override
    public boolean isSortedAscending() {
        if(null == this.sortAscending) {
            //return default value
            return Preferences.instance().getBoolean("browser.sort.ascending");
        }
        return this.sortAscending;
    }

    public boolean tableView_shouldTypeSelectForEvent_withCurrentSearchString(
            NSTableView tableView, NSEvent event, String searchString) {
        return this.isTypeSelectSupported();
    }

    protected abstract boolean isTypeSelectSupported();

    /**
     * You should implement this method if your table supports varying row heights.
     * <p/>
     * Although table views may cache the returned values, you should ensure that this
     * method is efficient. When you change a row's height you must invalidate the
     * existing row height by calling noteHeightOfRowsWithIndexesChanged:. NSTableView
     * automatically invalidates its entire row height cache when reloadData and
     * noteNumberOfRowsChanged are called.
     *
     * @param tableView The table view that sent the message.
     * @param row       The row index.
     * @return The height of the row. The height should not include intercell spacing and must be greater than zero.
     */
//    public CGFloat tableView_heightOfRow(NSTableView tableView, NSInteger row);

    /**
     * Values returned by this method should not include intercell spacing and must be greater than 0. Implement
     * this method to support an outline view with varying row heights.
     * <p/>
     * Special Considerations. For large tables in particular, you should make sure that this method is
     * efficient. NSTableView
     * may cache the values this method returns, so if you would like to change a row's height
     * make sure to invalidate the row height by calling noteHeightOfRowsWithIndexesChanged:. NSTableView
     * automatically invalidates its entire row height cache in reloadData and noteNumberOfRowsChanged.
     *
     * @param outlineView
     * @param item
     * @return
     */
//    public CGFloat outlineView_heightOfRowByItem(NSOutlineView outlineView, NSObject item);
}
