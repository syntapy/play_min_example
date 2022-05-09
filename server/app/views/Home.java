package views;

import static j2html.TagCreator.html;
import static j2html.TagCreator.head;
import static j2html.TagCreator.meta;

import static j2html.TagCreator.body;
import static j2html.TagCreator.header;
import static j2html.TagCreator.title;
import static j2html.TagCreator.main;

import static j2html.TagCreator.document;

import static j2html.TagCreator.h1;
import static j2html.TagCreator.p;
import static j2html.TagCreator.div;
import static j2html.TagCreator.span;

import j2html.tags.Tag;
import j2html.tags.ContainerTag;

import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.HtmlTag;
import j2html.tags.specialized.HeadTag;

import play.twirl.api.Content;

public class Home {

  private static HeadTag renderHead() {
    return head().with(title("Toy Play APP"));
  }

  private static ContainerTag getDivTag() {
    ContainerTag divTag = div();

    divTag.with(div("Hello"));

    return divTag;
  }

  private static ContainerTag renderH1() {
    Tag spanTag = span("Toy PLAY application");
    ContainerTag divTag = getDivTag();
    divTag.with(spanTag);
    return h1().with(divTag);
  }

  private static ContainerTag renderBody() {
    return body().with(renderH1());
  }

  public static Content render() {
    HtmlTag htmlContainer = html().with(renderHead(), renderBody());
    return new HtmlBundleContent(htmlContainer);
  }

  private static class HtmlBundleContent implements Content {
    HtmlTag bundleContent;

    public HtmlBundleContent(HtmlTag bundleContent) {
      this.bundleContent = bundleContent;
    }

    @Override
    public String body() {
      return document(bundleContent);
    }

    @Override
    public String contentType() {
      return "text/html";
    }
  }
}
