package db

class SubscriberRepository(private val dao: SubscriberDAO) {
    val subscribers = dao.getAllSubsriber()

    suspend fun insert(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }
    suspend fun updat(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }
    suspend fun delete(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
}