/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.sites;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.data.Link;
import com.google.gdata.data.extensions.FeedLink;
import com.google.gdata.util.Namespaces;

/**
 * Describes an announcements page entry.
 *
 * 
 */
@Kind.Term(AnnouncementsPageEntry.KIND)
public class AnnouncementsPageEntry extends
    BasePageEntry<AnnouncementsPageEntry> {

  /**
   * Announcementspage announcements page kind kind term value.
   */
  public static final String KIND = SitesNamespace.SITES_PREFIX +
      "announcementspage";

  /**
   * Announcementspage announcements page kind kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind, KIND,
      "announcementspage");

  /**
   * Default mutable constructor.
   */
  public AnnouncementsPageEntry() {
    super();
    getCategories().add(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link BaseEntry} instance.
   *
   * @param sourceEntry source entry
   */
  public AnnouncementsPageEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
  }

  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    if (extProfile.isDeclared(AnnouncementsPageEntry.class)) {
      return;
    }
    super.declareExtensions(extProfile);
    extProfile.declare(AnnouncementsPageEntry.class,
        new ExtensionDescription(FeedLink.class, new XmlNamespace("gd",
        "http://schemas.google.com/g/2005"), "feedLink", true, false, false));
    new FeedLink().declareExtensions(extProfile);
  }

  /**
   * Returns the A feedLink element representing the feed for announcements in
   * this page.
   *
   * @return A feedLink element representing the feed for announcements in this
   *     page
   */
  public FeedLink getFeedLink() {
    return getExtension(FeedLink.class);
  }

  /**
   * Sets the A feedLink element representing the feed for announcements in this
   * page.
   *
   * @param feedLink A feedLink element representing the feed for announcements
   *     in this page or <code>null</code> to reset
   */
  public void setFeedLink(FeedLink feedLink) {
    if (feedLink == null) {
      removeExtension(FeedLink.class);
    } else {
      setExtension(feedLink);
    }
  }

  /**
   * Returns whether it has the A feedLink element representing the feed for
   * announcements in this page.
   *
   * @return whether it has the A feedLink element representing the feed for
   *     announcements in this page
   */
  public boolean hasFeedLink() {
    return hasExtension(FeedLink.class);
  }

  /**
   * Returns the attachments sites link.
   *
   * @return Attachments sites link or {@code null} for none.
   */
  public Link getAtomAttachmentsLink() {
    return getLink(SitesLink.Rel.ATTACHMENTS, Link.Type.ATOM);
  }

  /**
   * Returns the replies sites link.
   *
   * @return Replies sites link or {@code null} for none.
   */
  public Link getAtomRepliesLink() {
    return getLink(SitesLink.Rel.REPLIES, Link.Type.ATOM);
  }

  /**
   * Returns the attachments sites link.
   *
   * @return Attachments sites link or {@code null} for none.
   */
  public Link getHtmlAttachmentsLink() {
    return getLink(SitesLink.Rel.ATTACHMENTS, Link.Type.HTML);
  }

  /**
   * Returns the replies sites link.
   *
   * @return Replies sites link or {@code null} for none.
   */
  public Link getHtmlRepliesLink() {
    return getLink(SitesLink.Rel.REPLIES, Link.Type.HTML);
  }

  /**
   * Returns the parent sites link.
   *
   * @return Parent sites link or {@code null} for none.
   */
  public Link getParentLink() {
    return getLink(SitesLink.Rel.PARENT, Link.Type.ATOM);
  }

  @Override
  protected void validate() {
  }

  @Override
  public String toString() {
    return "{AnnouncementsPageEntry " + super.toString() + "}";
  }

}
