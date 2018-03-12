package com.twitter.api;

import org.springframework.stereotype.Component;

import com.twitter.adapter.SearchAdapter;
import com.twitter.converter.InputConverter;
import com.twitter.converter.OutputConverter;

@Component
public class SearchBuilder {
	
	public SearchAdapter searchAdapter;
	public InputConverter inputConverter;
	public OutputConverter outputConverter;
	
	public SearchBuilder adapter(SearchAdapter searchAdapter) {
		this.searchAdapter=searchAdapter;
		return this;
	}
	
	public SearchBuilder inputConverter(InputConverter inputConverter) {
		this.inputConverter=inputConverter;
		return this;
	}
	
	public SearchBuilder outputConverter(OutputConverter outputConverter) {
		this.outputConverter=outputConverter;
		return this;
	}
	
	public SearchAPI build() {
		return new SearchAPI(this);
	}

}
