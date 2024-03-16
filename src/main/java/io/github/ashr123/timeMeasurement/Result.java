package io.github.ashr123.timeMeasurement;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Result<T> {
	private final T result;
	private final long timeTaken;
	private final boolean isContainsResult;

	Result(final long startTime, final long endTime) {
		this(startTime, null, endTime, false);
	}

	Result(final long startTime, final T result, final long endTime) {
		this(startTime, result, endTime, true);
	}

	private Result(final long startTime, final T result, final long endTime, final boolean isContainsResult) {
		this.result = result;
		this.timeTaken = endTime - startTime;
		this.isContainsResult = isContainsResult;
	}

	/**
	 * @return the result of the given function, if the function didn't return any result, {@link NoSuchElementException} is thrown
	 */
	public T getResult() {
		if (isContainsResult)
			return result;
		throw new NoSuchElementException("No result is present");
	}

	/**
	 * @return the time took for the code to complete by default timescale of milliseconds
	 * @see Result#getTimeTaken(TimeScales)
	 */
	public double getTimeTaken() {
		return getTimeTaken(TimeScales.MILLISECONDS);
	}

	/**
	 * @param timeScales the required timescale
	 * @return the time took for the code to complete by the given timescale
	 * @see Result#getTimeTaken()
	 */
	public double getTimeTaken(TimeScales timeScales) {
		return timeTaken / timeScales.getScale();
	}

	public Duration toDuration() {
		return Duration.ofNanos(timeTaken);
	}

	@Override
	public boolean equals(Object o) {
		return this == o ||
				o instanceof Result<?> result &&
						timeTaken == result.timeTaken &&
						isContainsResult == result.isContainsResult &&
						Objects.equals(this.result, result.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(result, timeTaken, isContainsResult);
	}

	@Override
	public String toString() {
		return "Result{" +
				"result=" + result +
				", timeTaken=" + timeTaken +
				", isContainsResult=" + isContainsResult +
				'}';
	}
}
