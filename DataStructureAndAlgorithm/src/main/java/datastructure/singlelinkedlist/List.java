package datastructure.singlelinkedlist;

import java.util.function.Consumer;

@FunctionalInterface
public interface List<T> {
	
	public void foreach(Consumer<T> consumer);
}
