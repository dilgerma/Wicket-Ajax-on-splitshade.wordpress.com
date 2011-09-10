package de.md;

import org.apache.wicket.model.LoadableDetachableModel;

public class ExceptinThrowingModel extends LoadableDetachableModel{

	@Override
	protected Object load() {
		
		throw new RuntimeException("Error loading Component");
	}

}
