# apps20liubas-hw2
Завдання:
Реалізуйте класи ImmutableLinkedList (зв'язаний список) і ImmutableArrayList (динамічний масив), що реалізують інтерфейс ImmutableList. 
Колекції є Immutable, тому не можна змінювати стану існуючої колекції. Тому всі операції які можуть змінювати стан мають повертати нову колекції.
		
Тобто після виконання наступного фрагменту коду:
ImmutableList immutableList = …;
ImmutableList newImmutableList = immutableList.add(“abc”);
змінна immutableList не буде містити новий доданий елемент.
		
При реалізації інтерфейсу ImmutableList класами ImmutableLinkedList або ImmutableArrayList, методи інтерфейсу що повертають ImmutableList мають повертати колекції конкретного типу (тобто ImmutableLinkedList або ImmutableArrayList)

ImmutableLinkedList, додатково до методів з п.1 повинен мати наступні методи:

public ImmutableLinkedList addFirst(Object e) - додає елемент у початок зв'язаного списку

public ImmutableLinkedList addLast(Object e) - додає елемент у кінець зв'язаного списку

public Object getFirst()

public Object getLast()

public ImmutableLinkedList removeFirst() - видаляє перший елемент

public ImmutableLinkedList removeLast() - видаляє останній елемент

Використовуючи ImmutableLinkedList реалізуйте класи Queue та Stack - дані класи не мають бути Immutable (!!!)
	
Queue:
Object peek() - Returns the object at the beginning of the Queue without removing it
Object dequeue() - Removes and returns the object at the beginning of the Queue.
void enqueue(Object e) - Adds an object to the end of the Queue.

Stack:
Object peek() - Returns the object from the top of the Stack without removing it
Object pop() - Removes and returns the object from the top of the Stack
void push(Object e) - Adds an object to the the top of the Stack

Необхідно написати модульні тести
