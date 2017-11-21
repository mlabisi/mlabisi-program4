import java.util.Iterator;
/************************************************************
 * File:    Dictionary.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/21/17
 *
 * Description:
 * This java class is the implementation of the Dictionary
 * data structure.
 ************************************************************/
public class Dictionary<K, T> implements DictionaryInterface<K, T> {
    /**
     * method:  add
     * purpose: adds a new entry to the dictionary; replaces existing
     * entries if needed
     *
     * @param key   search key of the new entry
     * @param value the value associated with the search key
     * @return null if the entry was added, or the value that was
     * replaced.
     */
    @Override
    public T add(K key, T value) {
        return null;
    }

    /**
     * method:  remove
     * purpose: removes a specific entry from the dictionary
     *
     * @param key search key of the entry to be removed
     * @return the value that was associated with the search key
     * or null if the entry doesn't exist
     */
    @Override
    public T remove(K key) {
        return null;
    }

    /**
     * method:  getValue
     * purpose: retrieves the value associated with the given key
     *
     * @param key search key of the entry to be retrieved
     * @return the value that is associated with the key or null
     * if the entry doesn't exist
     */
    @Override
    public T getValue(K key) {
        return null;
    }

    /**
     * method:  contains
     * purpose: checks whether or not a specific entry is in the
     * dictionary
     *
     * @param key the search key associated with the entry to be
     *            found
     * @return true or false depending on whether or not the key
     * is associated with an entry in the dictionary
     */
    @Override
    public boolean contains(K key) {
        return false;
    }

    /**
     * method:  getKeyIterator
     * purpose: creates an iterator that traverses the keys in the
     * dictionary
     *
     * @return an iterator with sequential access to the search keys
     * in the dictionary
     */
    @Override
    public Iterator<K> getKeyIterator() {
        return null;
    }

    /**
     * method:  getValueIterator
     * purpose: creates an iterator that traverses the values in the
     * dictionary
     *
     * @return an iterator with sequential access to the values in the
     * dictionary
     */
    @Override
    public Iterator<T> getValueIterator() {
        return null;
    }

    /**
     * method:  isEmpty
     * purpose: checks whether or not the dictionary is empty
     *
     * @return true or false depending on whether or not the dictionary
     * is empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * method:  getSize
     * purpose: gets the size of the dictionary
     *
     * @return the number of key-value pairs in the dictionary
     */
    @Override
    public int getSize() {
        return 0;
    }

    /**
     * method:  clear
     * purpose: removes all entries from the dictionary
     */
    @Override
    public void clear() {

    }
}
