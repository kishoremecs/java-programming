Spring Batch :

Spring Batch framework is divided into three parts.
	1. Core
	2. Infrastructure
	3. Application.

#Core
The core module contains all spring batch job related configuration & component classes.
Some of the important interfaces you find in core module are :
	1. JobOperator
	2. JobLauncher
	3. JobExplorer
	4. JobRegistry

	Spring Batch has spring-batch namespace for supporting spring batch related operations.
	We can create the above classes as spring beans as below :

		<batch:job-repository data-source="dataSource" id="jobRepository"
		transaction-manager="transactionManager" table-prefix="${batch.table.prefix}"/>
	The above xml snippet creates a batch job repository.
	This is just an example. I will cover the detail configuration in another page.
	
#Infrastructure
The Infrastructure module contains lot of out of the box reader and writers along with the key interfaces.
The key interfaces are :
	1. ItemReader
	2. ItemWriter
	3. ItemProcessor

	Builtin readers are:
	1. AmqpItemReader
	2. FlatFileItemReader
	3. HibernatePagingItemReader
	4. ItemReaderAdapter
	5. JdbcPagingItemReader
	6. JpaPagingItemReader
	7. MongoItemReader
	8. RepositoryItemReader
	9. StaxEventItemReader
   10. AggregateItemReader
   11. HibernateCursorItemReader
   12. IbatisPagingItemReader
   13. JdbcCursorItemReader
   14. JmsItemReader
   15. ListItemReader
   16. Neo4jItemReader
   17. StoredProcedureItemReader

   	Builtin writers are:
	1. AbstractItemStreamItemWriter
	2. CompositeItemWriter
	3. GemfireItemWriter
	4. IbatisBatchItemwriter
	5. JdbcBatchItemWriter
	6. JpaBatchItemWriter
	7. MongoItemWriter
	8. StaxEventItemWriter
	9. AmqpItemWriter
   10. FlatFileItemWriter
   11. HibernateItemWriter
   12. ItemWriterAdapter
   13. JmsItemWriter
   14. MimeMessageItemWriter
   15. Neo4jItemWriter
   16. RepositoryItemWriter

	