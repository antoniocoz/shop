package com.alten.shop.exception;

/**
 * Classe pour gerer les exceptions
 * @author owner
 *
 */
public class TechnicalShopException extends RuntimeException  {
	
	private static final long serialVersionUID = -581690764965050278L;

	public TechnicalShopException() {
		super();
	}
	
	public TechnicalShopException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	public TechnicalShopException(final String message) {
		super(message);
	}
}
