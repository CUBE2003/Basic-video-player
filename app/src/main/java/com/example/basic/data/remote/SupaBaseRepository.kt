import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basic.data.model.VideoDetails
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SupabaseRepository {
    private val supabase = createSupabaseClient(
        supabaseUrl = "https://mmijpztahsjperpaxqtr.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1taWpwenRhaHNqcGVycGF4cXRyIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTUxODYxMzMsImV4cCI6MjAzMDc2MjEzM30.aR1DbeVytKYEt7PbtoyfHqiISfAv46qDyq9avdpExTg"
    ) {
        install(Postgrest)
    }

    suspend fun getVideoDetails(): LiveData<List<VideoDetails>> {
        return withContext(Dispatchers.IO) {
            val resultLiveData = MutableLiveData<List<VideoDetails>>()

            try {
                val data = supabase.from("badic_videoplayer").select().decodeList<VideoDetails>()
                Log.d("SupabaseRepository", "Fetched video details: $data")
                resultLiveData.postValue(data)
            } catch (e: Exception) {
                Log.e("SupabaseRepository", "Error fetching video details: ", e)
                resultLiveData.postValue(emptyList())
            }

            resultLiveData
        }
    }

    suspend fun searchVideos(searchQuery: String): List<VideoDetails> {
        return withContext(Dispatchers.IO) {
            try {
                val query = supabase.from("badic_videoplayer")
                    .select() {
                        filter {
                            ilike("title", "%$searchQuery%")  // Contains the searchQuery
                        }
                    }

                val data = query.decodeList<VideoDetails>()
                Log.d("SupabaseRepository", "Searched video details: $data")
                data
            } catch (e: Exception) {
                Log.e("SupabaseRepository", "Error searching videos: ", e)
                emptyList()
            }
        }
    }
}
