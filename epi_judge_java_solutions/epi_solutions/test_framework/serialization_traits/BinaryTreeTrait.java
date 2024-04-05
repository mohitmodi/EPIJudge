
package epi_solutions.test_framework.serialization_traits;

import epi.TreeLike;
import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.minimal_json.JsonArray;
import epi.test_framework.minimal_json.JsonValue;
import epi.test_framework.serialization_traits.SerializationTrait;
import epi_solutions.BinaryTree;
import epi_solutions.BinaryTreeNode;
import epi_solutions.BstNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTrait extends epi.test_framework.serialization_traits.SerializationTrait {
  private Class<?> nodeType;
  private epi.test_framework.serialization_traits.SerializationTrait innerTypeTrait;

  public BinaryTreeTrait(Class<?> nodeType, SerializationTrait innerTypeTrait) {
    this.nodeType = nodeType;
    this.innerTypeTrait = innerTypeTrait;
  }

  @Override
  public String name() {
    return String.format("binary_tree(%s)", innerTypeTrait.name());
  }

  @Override
  public Object parse(JsonValue jsonObject) {
    if (nodeType.equals(epi_solutions.BinaryTreeNode.class)) {
      return buildBinaryTreeNode(jsonObject.asArray());
    } else if (nodeType.equals(epi_solutions.BinaryTree.class)) {
      return buildBinaryTree(jsonObject.asArray());
    } else if (nodeType.equals(epi_solutions.BstNode.class)) {
      return buildBstNode(jsonObject.asArray());
    } else {
      throw new RuntimeException(
          String.format("Binary Tree parser: %s class is not supported",
                        nodeType.toString()));
    }
  }

  @Override
  public List<String> getMetricNames(String argName) {
    return Arrays.asList(String.format("size(%s)", argName),
                         String.format("height(%s)", argName));
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Integer> getMetrics(Object x) {
    return List.of(BinaryTreeUtils.binaryTreeSize((TreeLike<Object, ?>)x),
                   BinaryTreeUtils.binaryTreeHeight((TreeLike<Object, ?>)x));
  }

  private Object buildBinaryTreeNode(JsonArray data) {
    List<epi_solutions.BinaryTreeNode<Object>> nodes = new LinkedList<>();
    for (JsonValue node : data) {
      nodes.add(node.isNull()
                    ? null
                    : new epi_solutions.BinaryTreeNode<>(innerTypeTrait.parse(node)));
    }

    Deque<epi_solutions.BinaryTreeNode<Object>> candidateChildren = new LinkedList<>(nodes);
    epi_solutions.BinaryTreeNode<Object> root = candidateChildren.removeFirst();
    for (BinaryTreeNode<Object> node : nodes) {
      if (node != null) {
        if (!candidateChildren.isEmpty()) {
          node.left = candidateChildren.removeFirst();
        }
        if (!candidateChildren.isEmpty()) {
          node.right = candidateChildren.removeFirst();
        }
      }
    }
    return root;
  }

  private Object buildBinaryTree(JsonArray data) {
    List<epi_solutions.BinaryTree<Object>> nodes = new LinkedList<>();
    for (JsonValue node : data) {
      nodes.add(node.isNull() ? null
                              : new epi_solutions.BinaryTree<>(innerTypeTrait.parse(node)));
    }

    Deque<epi_solutions.BinaryTree<Object>> candidateChildren = new LinkedList<>(nodes);
    epi_solutions.BinaryTree<Object> root = candidateChildren.removeFirst();
    for (BinaryTree<Object> node : nodes) {
      if (node != null) {
        if (!candidateChildren.isEmpty()) {
          node.left = candidateChildren.removeFirst();
          if (node.left != null) {
            node.left.parent = node;
          }
        }
        if (!candidateChildren.isEmpty()) {
          node.right = candidateChildren.removeFirst();
          if (node.right != null) {
            node.right.parent = node;
          }
        }
      }
    }
    return root;
  }

  private Object buildBstNode(JsonArray data) {
    List<epi_solutions.BstNode<Object>> nodes = new LinkedList<>();
    for (JsonValue node : data) {
      nodes.add(node.isNull() ? null
                              : new epi_solutions.BstNode<>(innerTypeTrait.parse(node)));
    }

    Deque<epi_solutions.BstNode<Object>> candidateChildren = new LinkedList<>(nodes);
    epi_solutions.BstNode<Object> root = candidateChildren.removeFirst();
    for (BstNode<Object> node : nodes) {
      if (node != null) {
        if (!candidateChildren.isEmpty()) {
          node.left = candidateChildren.removeFirst();
        }
        if (!candidateChildren.isEmpty()) {
          node.right = candidateChildren.removeFirst();
        }
      }
    }
    return root;
  }
}
