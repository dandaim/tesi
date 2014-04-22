package com.ufrj.dcc.tesi.domain;

public enum Period {

	FIRST( 1 ),

	SECOND( 2 );

	private int value;

	Period( int value ) {
		this.value = value;
	}

	public Period getByValue( int value ) {

		for ( Period period : Period.values() ) {
			if ( period.getValue() == value ) {
				return period;
			}
		}

		return null;
	}

	public int getValue() {
		return value;
	}

}
