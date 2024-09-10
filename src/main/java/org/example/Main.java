package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import org.hibernate.Session;
import org.hibernate.Transaction;

        public class Main {
            public static void main(String[] args) {
                // Получаем сессию
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = null;

                try {
                    // Начинаем транзакцию
                    transaction = session.beginTransaction();

                    // Создаем и сохраняем объекты Person
                    Person person1 = new Person("John", "Doe", 28);
                    Person person2 = new Person("Jane", "Smith", 22);
                    session.save(person1);
                    session.save(person2);

                    // Завершаем транзакцию
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e.printStackTrace();
                } finally {
                    session.close();
                }

                // Закрываем сессию Hibernate
                HibernateUtil.shutdown();
            }
        }

