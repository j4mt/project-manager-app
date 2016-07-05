package org.jor.productinventory.repository;

import org.jor.productinventory.business.Entity;

import java.util.Collection;

/**
 * Created by j4mt on 04/07/16.
 * <p>
 * Implement storage backend with RandomAccessFile
 * <p>
 * https://docs.oracle.com/javase/7/docs/api/java/io/RandomAccessFile.html
 * http://www.tutorialspoint.com/java/io/java_io_randomaccessfile.htm
 * http://www.java2s.com/Tutorials/Java/Java_io/0600__Java_io_Random_Access_Files.htm
 * http://www.java-tips.org/java-se-tips-100019/18-java-io/1998-how-to-use-random-access-file.html
 * https://examples.javacodegeeks.com/core-java/io/randomaccessfile/java-randomaccessfile-example/
 *
 * @param <T>  the type parameter
 * @param <Pk> the type parameter
 */
public class FileRepository<T extends Entity<Pk>, Pk> implements Repository<T, Pk> {

    @Override
    public T find(Pk key) {
        return null;
    }

    @Override
    public Collection<T> findAll() {
        return null;
    }

    @Override
    public void create(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public boolean delete(T entity) {
        return false;
    }

    @Override
    public boolean delete(Pk key) {
        return false;
    }

    @Override
    public boolean exists(T entity) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
