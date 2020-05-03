// Introduced in Chapter 11
/** A set of Objects. */
public interface Set<E> {

	/** Add target to this Set. */
	public void add(E target);

	/** Return true if this Set contains target. */
	public boolean contains(E target);

	/** Remove target from this Set. */
	public void remove(E target);

	/** add all target in a set to another set */
	public void addAll(Set<E> target);

	/** Return the number of elements in this Set. */
	public int size();

	/** return the target that two set all have in source set */
	public void retainAll(Set<E> target);
}
