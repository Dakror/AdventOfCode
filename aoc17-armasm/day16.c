#include <stdlib.h>
#include <stdio.h>

struct node {
	char p;
	struct node* next;
	struct node* prev;
	struct node* end;
};

struct node* add(struct node* list, char c) {
	if(list->next == NULL) {
		struct node* n = malloc(sizeof(struct node));
		*n = (struct node){c, NULL, list, n};
		list->next = n;
		list->end = n;
		return n;
	} else {
		return add(list->next, c);
	}
}

struct node* spin(struct node* list, int num) {
	
}

int main(void) {
	struct node* list = malloc(sizeof(struct node));
	*list = (struct node){'a', NULL, NULL, list};

	char* str = "abcdefghijklmnop";
	
	for(int i = 1; i < 16; i++) {
		add(list, str[i]);
	}
	
	struct node* l = list;
	do {
		printf("%c", l->p);
		l = l->next;
	} while(l != NULL);
	
	return 0;
}