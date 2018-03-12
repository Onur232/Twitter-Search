package com.twitter.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twitter.api.SearchAPI;
import com.twitter.api.SearchBuilder;
import com.twitter.api.SearchInput;
import com.twitter.api.SearchOutput;
import com.twitter.bootstrap.SearchAPIBootstrap;
import com.twitter.converter.InputConverter;
import com.twitter.converter.OutputConverter;
import com.twitter.enums.SearchType;;

@Component
public class TwitterAdapter implements SearchAdapter{
	
	private SearchAPIBootstrap searchAPIBootstrap;
	private SearchBuilder searchBuilder;
	
	@Autowired
	public void setSearchAPIBootstrap(SearchAPIBootstrap searchAPIBootstrap) {
		this.searchAPIBootstrap = searchAPIBootstrap;
	}
	
	@Autowired
	public void setSearchBuilder(SearchBuilder searchBuilder) {
		this.searchBuilder = searchBuilder;
	}

	
	public SearchOutput search(SearchInput input, SearchType searchType) {
		SearchAdapter adapter = searchAPIBootstrap.getAdapters().get(searchType.getValue());
		InputConverter inputConverter = searchAPIBootstrap.getInputConverters().get(searchType.getValue());
		OutputConverter outputConverter = searchAPIBootstrap.getOutputConverters().get(searchType.getValue());
		SearchAPI api=searchBuilder
		.adapter(adapter)
		.inputConverter(inputConverter)
		.outputConverter(outputConverter)
		.build();
		return api.search(input);
		}
	
}
