package com.qq986945193.javaweb.knowledge;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * ThreadLocal的用法
 */
public class ThreadLocalIntroduce {
	/**
	 * ThreadLocal只能本线程的才可以使用 实现原理，底层是一个map,键是当前线程的名字，所以重复存取或 替换掉原来的数据
	 */
	@Test
	public void funTest() {
		/**
		 * ThreadLocal三个方法，set(),get(),remove()。根据泛型来绝对存取什么类型的数据
		 */
		ThreadLocal<String> tl = new ThreadLocal<String>();
		tl.set("hello");
		// System.out.println(tl.get());
		// tl.remove();

		new Thread(new Runnable() {
			public void run() {
				System.out.println("测试其他线程不能使用：" + tl.get());
			}
		}).start();
	}

	@Test
	public void ThreadLocalBase() {
		Map<Thread, String> map = new HashMap<Thread, String>();
		map.put(Thread.currentThread(), "ThreadLocalBase");
		System.out.println(map.get(Thread.currentThread()));
		new Thread(new Runnable() {

			@Override
			public void run() {
				// Thread-0
				System.out.println("1:" + Thread.currentThread().getName());
				// null
				System.out.println("2:" + map.get(Thread.currentThread()));
			}
		}).start();
	}

}

/**
 * threadlocal的实现原理
 */
class Threadlocal<T> {
	// 以当前thread作为键，传来的T为类型
	private Map<Thread, T> map = new HashMap<Thread, T>();

	public void set(T t) {
		map.put(Thread.currentThread(), t);
	}

	public void get() {
		map.get(Thread.currentThread());
	}

	public void remove() {
		map.remove(Thread.currentThread());
	}

	/**
	 * ThreadLocal通常用在一个类的成员上 多个线程访问它时，每个线程都有自己的副本，互不干扰！
	 * Spring中把Connection放到了ThreadLocal中！
	 */
class User {
	private ThreadLocal<String> username = new ThreadLocal<String>();
}

}
