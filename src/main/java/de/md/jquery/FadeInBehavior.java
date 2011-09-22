package de.md.jquery;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxCallDecorator;
import org.apache.wicket.ajax.calldecorator.AjaxCallDecorator;
import org.apache.wicket.model.util.MapModel;
import org.apache.wicket.resource.TextTemplateResourceReference;
import org.apache.wicket.util.template.PackageTextTemplate;

public class FadeInBehavior extends AjaxEventBehavior {

	
	public FadeInBehavior(String event) {
		super(event);
	}

	@Override
	protected IAjaxCallDecorator getAjaxCallDecorator() {
		return new AjaxCallDecorator() {
			@Override
			public CharSequence decorateScript(Component c, CharSequence script) {
				PackageTextTemplate template = new PackageTextTemplate(FadeInBehavior.class, "fadein.js");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", getComponent().getMarkupId());
				return template.interpolate(map).asString();
			}
		};
	}

	@Override
	protected void onEvent(AjaxRequestTarget target) {
		//never called
	}
	
	
	
	
	
}
