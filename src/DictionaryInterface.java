import java.util.Iterator;
/************************************************************
 * File:    DictionaryInterface.java
 * Author:  Mora Labisi
 * Course:  CS 241.01 Data Structures and Algorithms II
 *
 * Assignment:  Program Four
 * Due:         Thursday, 11/30/2017
 *
 * Last Modified:   11/20/17
 *
 * Description:
 * This java interface is the implementation of the LinkedDictionary
 * data structure. It includes the method signatures
 * for the required functions of a LinkedDictionary.
 ************************************************************/
public interface DictionaryInterface<K, T> {

    /**
     * method:  add
     * purpose: adds a new entry to the dictionary; replaces existing
     *          entries if needed
     *
     * @param key   search key of the new entry
     * @param value the value associated with the search key
     * @return null if the entry was added, or the value that was
     *              replaced.
     */
    public T add(K key, T value);

    /**
     * method:  remove
     * purpose: removes a specific entry from the dictionary
     *
     * @param key search key of the entry to be removed
     * @return  the value that was associated with the search key
     *          or null if the entry doesn't exist
     */
    public T remove(K key);

    /**
     * method:  getValue
     * purpose: retrieves the value associated with the given key
     *
     * @param key search key of the entry to be retrieved
     * @return  the value that is associated with the key or null
     *          if the entry doesn't exist
     */
    public T getValue(K key);

    /**
     * method:  contains
     * purpose: checks whether or not a specific entry is in the
     *          dictionary
     *
     * @param key the search key associated with the entry to be
     *            found
     * @return  true or false depending on whether or not the key
     *          is associated with an entry in the dictionary
     */
    public boolean contains(K key);

    /**
     * method:  getKeyIterator
     * purpose: creates an iterator that traverses the keys in the
     *          dictionary
     *
     * @return  an iterator with sequential access to the search keys
     *          in the dictionary
     */
    public Iterator<K> getKeyIterator();

    /**
     * method:  getValueIterator
     * purpose: creates an iterator that traverses the values in the
     *          dictionary
     *
     * @return  an iterator with sequential access to the values in the
     *          dictionary
     */
    public Iterator<T> getValueIterator();

    /**
     * method:  isEmpty
     * purpose: checks whether or not the dictionary is empty
     *
     * @return  true or false depending on whether or not the dictionary
     *          is empty
     */
    public boolean isEmpty();

    /**
     * method:  getSize
     * purpose: gets the size of the dictionary
     *
     * @return  the number of key-value pairs in the dictionary
     */
    public int getSize();

    /**
     * method:  clear
     * purpose: removes all entries from the dictionary
     */
    public void clear();
}