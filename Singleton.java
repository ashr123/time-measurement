//package io.github.ashr123.timeMeasurement;
//
//import java.util.function.Supplier;
//
//public class Singleton<T> implements Supplier<T> {
//	private final Supplier<T> supplier;
//	private T result = null;
//	private boolean isSolved;
//
//	public Singleton(Supplier<T> supplier) {
//		this.supplier = supplier;
//	}
//
//	@Override
//	public final T get() {
//		if (!isSolved)
//			synchronized (this) {
//				if (!isSolved) {
//					isSolved = true;
//					return result = supplier.get();
//				}
//			}
//		return result;
//	}
//}
