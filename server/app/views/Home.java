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

import j2html.tags.Tag;
import j2html.tags.ContainerTag;

import play.twirl.api.Content;

public class Home {

  private static ContainerTag renderHead() {
    return head().with(title("Toy Play aPpLiCAtIonzZ"));
  }

  private static Tag renderH1() {
    return h1("This is A TOY PLay AppAlLicastionz");
  }

  private static ContainerTag renderBody() {
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
