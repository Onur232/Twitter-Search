package com.twitter.api;

import com.twitter.adapter.SearchAdapter;
import com.twitter.converter.InputConverter;
import com.twitter.converter.OutputConverter;

public class SearchAPI {
	
	private SearchAdapter searchAdapter;
	private InputConverter inputConverter;
	private OutputConverter outputConverter;
	private SearchOutput searchOutput;
	
	SearchAPI(SearchBuilder builder) {
		this.searchAdapter=builder.searchAdapter;
		this.inputConverter=builder.inputConverter;
		this.outputConverter=builder.outputConverter;
	}

	public SearchOutput search(SearchInput searchInput) {
		return searchOutput;
	}
}
