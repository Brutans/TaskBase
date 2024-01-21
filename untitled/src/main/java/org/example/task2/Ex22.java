package org.example.task2;

import org.w3c.dom.NodeList;

import java.util.LinkedList;

public class Ex22 {
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        class LinkerdList<T> {
            private Node<T> head;

            public void add(T data) {
                Node<T> newNode = new Node<>(data);
                //Список пуск добавляется элемент как head
                if (head == null) {
                    head = newNode;
                } else {
                    //Проходим весь список до конца и в конце создаём новый узел
                    Node<T> temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newNode;
                }
            }

            public T get(int index) {
                if (head == null || index < 0) {
                    return null;
                }
                Node<T> current = head;
                for (int i = 0; i < index; i++) {
                    if (current.next == null) {
                        return null;
                    }
                    current = current.next;
                }
                return current.data;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(10);
        integerLinkedList.add(20);
        integerLinkedList.add(30);
        for (int i = 0; i < 3; i++) {
            System.out.println("Элемент с индексом" + i + ": " + integerLinkedList.get(i));
        }

    }
}
