package br.com.nova.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.nova.erudio.exception.UnsupportedMathOperetionException;
import br.com.nova.erudio.math.SimpleMath;
import br.com.nova.erudio.math.converters;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath methods = new SimpleMath();
	private converters converters;

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!converters.isNumeric(numberOne) || !converters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperetionException("Please set a numeric value!");

		}
		return methods.sum(numberOne, numberTwo);
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!converters.isNumeric(numberOne) || !converters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperetionException("Please set a numeric value!");

		}
		return methods.div(numberOne, numberTwo);
	}

	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double Multi(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!converters.isNumeric(numberOne) || !converters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperetionException("Please set a numeric value!");

		}
		return methods.multi(numberOne, numberTwo);
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!converters.isNumeric(numberOne) || !converters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperetionException("Please set a numeric value!");

		}
		return methods.sub(numberOne, numberTwo);
	}

	@RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!converters.isNumeric(numberOne) || !converters.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperetionException("Please set a numeric value!");

		}
		return methods.med(numberOne, numberTwo);
	}

	@RequestMapping(value = "/raiz/{number}", method = RequestMethod.GET)
	public Double raiz(@PathVariable(value = "number") String number) throws Exception {

		if (!converters.isNumeric(number)) {
			throw new UnsupportedMathOperetionException("Please set a numeric value!");

		}
		return Math.sqrt(methods.convertToDouble(number));
	}

}
