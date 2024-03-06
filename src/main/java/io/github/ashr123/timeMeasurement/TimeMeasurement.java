package io.github.ashr123.timeMeasurement;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class TimeMeasurement {
	private TimeMeasurement() {
	}

	/**
	 * @param supplier the code that will be executed
	 * @param <T>      the type of the function's result object
	 * @return a {@link Result} object that contains the duration took for the function to execute
	 */
	public static <T> Result<T> measureAndExecute(final Supplier<T> supplier) {
		return new Result<>(System.nanoTime(), supplier.get(), System.nanoTime());
	}

	/**
	 * @param callable the code that will be executed
	 * @param <T>      the type of the function's result object
	 * @return a {@link Result} object that contains the duration took for the function to execute
	 * @throws Exception if the given code unable to executed normally
	 */
	public static <T> Result<T> measureAndExecuteCallable(final Callable<T> callable) throws Exception {
		return new Result<>(System.nanoTime(), callable.call(), System.nanoTime());
	}

	/**
	 * @param runnable code that doesn't return any value
	 * @return a {@link Result} object that contains only the duration took for the method to execute
	 */
	public static Result<Void> measureAndExecute(final Runnable runnable) {
		final long startTime = System.nanoTime();
		runnable.run();
		final long endTime = System.nanoTime();
		return new Result<>(startTime, endTime);
	}
}
