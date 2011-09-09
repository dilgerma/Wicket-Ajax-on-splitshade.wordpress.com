package de.md;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		add(new Label("hello", "splitshade.wordpress.com rulez"));

		/*
		 * AjaxLink
		 */
		add(new AjaxLink("ajaxLink") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				target.appendJavaScript("alert('hello world!');");
			}
		});

		/*
		 * Clickable Ajax Label
		 */
		Label label = new Label("ajaxText", "Ajax Clickable Text");
		add(label);
		label.add(new AjaxEventBehavior("onclick") {

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				throw new RuntimeException("I need to check that");
			}

			@Override
			protected CharSequence getFailureScript() {
				return "alert('there was a failure!!')";
			}

			@Override
			protected CharSequence getSuccessScript() {
				return "alert('Ajax call was successful')";
			}
		});

		/*
		 * Indicating Ajax Links
		 */
		add(indicatingAjaxLinks());
	}

	private Component indicatingAjaxLinks() {
		
		List<String> links = Arrays.asList(new String[] { "Link1", "Link2",
				"Link3", "Link4" });
		ListView<String> listView = new ListView<String>("linkList", links) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new IndicatingAjaxLink<Void>("indicatingAjaxLink") {

					private static final long serialVersionUID = 1L;

					protected AjaxEventBehavior newAjaxEventBehavior(String event) {
						return new AjaxEventBehavior("onclick"){

							@Override
							protected void onEvent(AjaxRequestTarget target) {
								onClick(target);
							}
							
							protected String getChannelName() {
								return "ajaxChannel|d";
							};
							
						};
					};
					
					@Override
					public void onClick(AjaxRequestTarget target) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}.add(new Label("message", item.getModelObject())));
			}
		};
		return listView;
	}
}
