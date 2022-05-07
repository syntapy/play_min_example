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

import play.twirl.api.Content;

public class Home {

  private static Tag renderHead() {
    Tag divTag = div();
    Tag spanTag = span("Toy Play application");
    return head().with(title(divTag.with(spanTag)));
  }

  private static Tag renderH1() {
    return h1("this is a toy play appallicastionz");
  }

  private static Tag renderBody() {
    return body().with(renderH1());
  }

  public static Content render() {
    ContainerTag htmlContainer = new ContainerTag("html").with(renderHead(), renderBody());
    return new HtmlBundleContent(htmlContainer);
  }

  private static class HtmlBundleContent implements Content {
    ContainerTag bundleContent;

    public HtmlBundleContent(ContainerTag bundleContent) {
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
