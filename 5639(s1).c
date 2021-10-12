#pragma warning(disable:4996)
#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
	struct Node* parent, * l, * r;
	int key;
}Node;
int findElement(Node* v, int k);
void insertItem(Node** v, int k);
Node* treeSearch(Node* v, int k);
int removeElement(Node** v, int k);

int isExternal(Node* v);
int  isInternal(Node* v);
Node* sibling(Node* w);
Node* inOrderSucc(Node* w);
Node* reduceExternal(Node** z);
Node* initNode();
void freeTree(Node* v);
void printTree(Node* v);
int main() {
	Node* root = initNode();
	int k;
	while (1)
	{
		if (scanf("%d", &k) == EOF) { break; }
		insertItem(&root, k);
	}
	printTree(root);
	freeTree(root);
}

Node* treeSearch(Node* v, int k) {
	if (isExternal(v)) return v;
	if (k == v->key) return v;
	else if (k < v->key) return treeSearch(v->l, k);
	else return treeSearch(v->r, k);
}
void insertItem(Node** v, int k) {

	Node* w = treeSearch(*v, k);
	if (isInternal(w)) return;
	else {
		w->key = k;
		w->l = initNode();
		w->r = initNode();
		w->l->parent = w;
		w->r->parent = w;
	}
}
int findElement(Node* v, int k) {
	Node* w = treeSearch(v, k);
	if (isInternal(w)) return w->key;
	else return -1;
}
int isExternal(Node* v) {
	if (v->l == NULL && v->r == NULL) return 1;
	else return 0;
}
int  isInternal(Node* v) {
	if (v->l != NULL && v->r != NULL)return 1;
	else return 0;
}
int removeElement(Node** v, int k) {

	Node* w = treeSearch(*v, k);

	if (isExternal(w))
		return -1;
	int key = w->key;
	Node* z = w->l;
	if (!isExternal(z))
		z = w->r;
	if (isExternal(z))
		reduceExternal(&z);

	else {
		Node* y = inOrderSucc(w);
		Node* z = y->l;
		w->key = y->key;
		reduceExternal(&z);
	}
	return key;
}

Node* reduceExternal(Node** z) {
	Node* w = (*z)->parent;
	Node* zs = sibling((*z));

	if (w->parent == NULL) {
		*w = *zs;
		zs->parent = NULL;
	}
	else {
		Node* g = w->parent;
		zs->parent = g;
		if (w == g->l)
			g->l = zs;
		else
			g->r = zs;
	}
	free(*z);
	if (zs->parent != NULL) free(w);
	return zs;

}

Node* sibling(Node* w) {
	if (w->parent->l == w)
		return w->parent->r;
	else
		return w->parent->l;
}
Node* inOrderSucc(Node* w) {
	w = w->r;
	while (isInternal(w->l))
		w = w->l;
	return w;
}

void printTree(Node* v) {
	if (isInternal(v)) {
		
		printTree(v->l);
		printTree(v->r);
		printf("%d\n", v->key);
	}
}
void freeTree(Node* v) {
	if (v) {
		freeTree(v->l);
		freeTree(v->r);
		free(v);
	}
}
Node* initNode() {
	Node* node = (Node*)malloc(sizeof(Node));
	node->l = node->r = node->parent = NULL;
	return node;
}
