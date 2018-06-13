package br.com.s2it.service.impl;
/**
Considerando a estrutura de uma árvore binária:

public class BinaryTree {
		int valor;
		BinaryTree left;
		BinaryTree right;
	}

Desenvolva um método que dado um nó da árvore calcule a soma de todos os nós subsequentes.

 */

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import br.com.s2it.domain.BinaryTree;
import br.com.s2it.service.BinaryTreeService;
import br.com.s2it.service.core.AbstractWsService;
import br.com.s2it.util.Assert;
import br.com.s2it.ws.BinaryTreeResponse;

/**
 * 
 * @author fulvio.falcao
 *
 */
@Service
public class BinaryTreeServiceImpl extends AbstractWsService implements BinaryTreeService {

	@Override
	public BinaryTreeResponse getSumBinaryTree(BinaryTree binaryTree, Integer node) {
		BinaryTreeResponse binaryTreeResponse = new BinaryTreeResponse();
		binaryTreeResponse.setSumNode(BigInteger.valueOf(courseTree(binaryTree, node)));
		return binaryTreeResponse;
	}

	private Integer courseTree(BinaryTree binaryTree, Integer node) {
		if (Assert.isNull(binaryTree)) {
			return node;
		}
		node = courseTree(binaryTree.getLeft(), node += binaryTree.getValor());
		return courseTree(binaryTree.getRight(), node);
	}
}
