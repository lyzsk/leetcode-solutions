package main

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var head *ListNode
	var tail *ListNode
	carry := 0
	for l1 != nil || l2 != nil {
		num1 := 0
		num2 := 0
		if l1 != nil {
			num1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			num2 = l2.Val
			l2 = l2.Next
		}
		sum := num1 + num2 + carry
		if head == nil {
			head = &ListNode{Val: sum % 10}
			tail = head
		} else {
			tail.Next = &ListNode{Val: sum % 10}
			tail = tail.Next
		}
		carry = sum / 10
	}
	if carry > 0 {
		tail.Next = &ListNode{Val: carry}
	}
	return head
}

type ListNode struct {
	Val  int
	Next *ListNode
}