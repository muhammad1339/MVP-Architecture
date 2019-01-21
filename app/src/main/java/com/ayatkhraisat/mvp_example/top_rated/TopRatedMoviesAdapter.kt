package com.ayatkhraisat.mvp_example.top_rated

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayatkhraisat.mvp_example.di.qualifires.Qualifiers
import com.ayatkhraisat.mvp_example.models.Model
import com.bumptech.glide.Glide
import com.notes.ayatkhraisat.mvp_example.R
import javax.inject.Inject


class TopRatedMoviesAdapter @Inject constructor(@Qualifiers.ActivityContext val context: Context) :
    RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder>() {


    private val  moviesList: ArrayList<Model.MovieItem?> = ArrayList()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var avatar: ImageView = itemView.findViewById(R.id.iv_movie_poster)
        var title: TextView = itemView.findViewById(R.id.tv_title)
        var rate: TextView = itemView.findViewById(R.id.tv_rate)

    }

    public fun setMoviesList(moviesList: ArrayList<Model.MovieItem?>?) {
        this.moviesList.clear()
        this.moviesList.addAll(moviesList!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = moviesList.get(position)

        holder.title.text = movie!!.title
        holder.rate.text = movie.voteAverage.toString()
        Glide.with(context)
            .load(
                "https://image.tmdb.org/t/p/w500${movie.posterPath}"
            )
            .into(holder.avatar)
    }


    override fun getItemCount(): Int {
            return  moviesList.size

    }

}