package queue
import scala.collection.mutable.ArrayBuffer
import java.util.NoSuchElementException

class Queue[T] {
  private val elems: ArrayBuffer[T] = new ArrayBuffer[T]()
  private var size = 0
  
  /**
   * Adds an element to the rear of the queue.
   */
  def enqueue(elem: T) {
    elems += elem
    size = size + 1
  }
  
  /**
   * Removes an element from the front of the queue.
   */
  def dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Cannot remove from an empty queue")
    else { 
      elems.remove(0)
      size = size - 1
    }
  }
  
  /**
   * Checks if queue is empty.
   */
  def isEmpty() = if (size == 0) true else false
  
  /**
   * Prints the elements in the queue.
   */
  override def toString() = elems.toString()
  
}

  /**
   * Companion Object & Tester
   */
  object Queue extends App {
    def apply = new Queue
    try {
      val waitingList = new Queue[String]
      waitingList.enqueue("Cisco")
      waitingList.enqueue("Barry")
      waitingList.enqueue("Caitlin")
      waitingList.enqueue("Harry")
      waitingList.enqueue("Joe")
      println(waitingList.toString())
      
      for (i <- 0 until waitingList.size) {
        waitingList.dequeue()
        println(waitingList.toString())
      }
      
      // Should throw exception here
      // waitingList.dequeue()
    }
    catch {
      case e: NoSuchElementException => println(e)
    }
  }

  