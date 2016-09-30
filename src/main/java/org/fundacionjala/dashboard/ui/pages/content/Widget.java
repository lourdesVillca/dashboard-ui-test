package org.fundacionjala.dashboard.ui.pages.content;

/**
 * This is enum the widget.
 */
public enum Widget {
    INFO,
    TABLE,
    LIST;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
