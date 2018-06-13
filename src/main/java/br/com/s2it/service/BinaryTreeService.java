package br.com.s2it.service;

import br.com.s2it.domain.BinaryTree;
import br.com.s2it.ws.BinaryTreeResponse;

public interface BinaryTreeService {
	BinaryTreeResponse getSumBinaryTree(BinaryTree binaryTree, Integer node);
}
