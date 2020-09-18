package il.co.timeMesurment;

public enum TimeScales
{
	NANOSECONDS(1D),
	MICROSECONDS(1000D * NANOSECONDS.scale),
	MILLISECONDS(1000D * MICROSECONDS.scale),
	SECONDS(1000D * MILLISECONDS.scale),
	MINUTES(60D * SECONDS.scale),
	HOURS(60D * MINUTES.scale),
	DAYS(24D * HOURS.scale);
	final double scale;

	double getScale()
	{
		return scale;
	}

	TimeScales(double scale)
	{
		this.scale = scale;
	}
}
