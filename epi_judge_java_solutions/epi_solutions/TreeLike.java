
package epi_solutions;

import epi_solutions.test_framework.BinaryTreeUtils;

public abstract class TreeLike<T, Node extends TreeLike<T, Node>> {
  public abstract T getData();
  public abstract Node getLeft();
  public abstract Node getRight();

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o instanceof TreeLike<?, ?>) {
      return epi_solutions.test_framework.BinaryTreeUtils.equalBinaryTrees((TreeLike<Object, ?>)this,
                                              (TreeLike<Object, ?>)o);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return epi_solutions.test_framework.BinaryTreeUtils.binaryTreeHash(this);
  }

  @Override
  public String toString() {
    return BinaryTreeUtils.binaryTreeToString(this);
  }
}
