package de.md.jquery;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * 
 * @author dilgerm
 *
 */
public class JQueryBehavior extends Behavior {

	private static final long serialVersionUID = 1L;
	
	public static final String JQUERY = "jquery-1.6.4.min.js";

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		response.renderJavaScriptReference(new PackageResourceReference(JQueryBehavior.class, JQUERY ));
	}
}
