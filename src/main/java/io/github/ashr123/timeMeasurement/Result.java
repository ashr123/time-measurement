package io.github.ashr123.timeMeasurement;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Result<T>
{
	private final T result;
	private final long timeTaken;
	private final boolean isContainsResult;

	Result(final long startTime, final long endTime)
	{
		this(startTime, null, endTime, false);
	}

	Result(final long startTime, final T result, final long endTime)
	{
		this(startTime, result, endTime, true);
	}

	private Result(final long startTime, final T result, final long endTime, final boolean isContainsResult)
	{
		this.result = result;
		this.timeTaken = endTime - startTime;
		this.isContainsResult = isContainsResult;
	}

	public T getResult()
	{
		if (isContainsResult)
			return result;
		throw new NoSuchElementException("No result present");
	}

	public double getTimeTaken()
	{
		return getTimeTaken(TimeScales.MILLISECONDS);
	}

	public double getTimeTaken(TimeScales timeScales)
	{
		return timeTaken / timeScales.getScale();
	}

	@Override
	public boolean equals(Object o)
	{
		return this == o ||
				o instanceof Result<?> result &&
						timeTaken == result.timeTaken &&
						isContainsResult == result.isContainsResult &&
						Objects.equals(this.result, result.result);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(result, timeTaken, isContainsResult);
	}

	@Override
	public String toString()
	{
		return "Result{" +
				"result=" + result +
				", timeTaken=" + timeTaken +
				", isContainsResult=" + isContainsResult +
				'}';
	}
}