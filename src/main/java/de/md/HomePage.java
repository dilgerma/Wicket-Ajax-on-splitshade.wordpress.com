package de.md;

import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
    	add(new Label("hello","splitshade.wordpress.com rulez"));
    	
    	add(new AjaxLink("ajaxLink"){
    		@Override
    		public void onClick(AjaxRequestTarget target) {
    			target.appendJavaScript("alert('hello world!');");
    		}
    	});
    	Label label = new Label("ajaxText","Ajax Clickable Text");
    	add(label);
    	label.add(new AjaxEventBehavior("onclick"){

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				target.appendJavaScript("alert('clicked')");
			}});
    }
}
