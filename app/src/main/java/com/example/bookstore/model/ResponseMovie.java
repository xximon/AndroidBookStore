package com.example.bookstore.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMovie {
    String status;
    @SerializedName(value = "status_message")
    String statusMsg;
    ResponseData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return "ResponseMovie{" +
                "status='" + status + '\'' +
                ", status_message='" + statusMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public class ResponseData{
        @SerializedName(value = "movie_count")
        int movieCount;
        int limit;
        @SerializedName(value = "page_number")
        int pageNum;
        List<Movie> movies;

        public int getMovieCount() {
            return movieCount;
        }

        public void setMovieCount(int movieCount) {
            this.movieCount = movieCount;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public List<Movie> getMovies() {
            return movies;
        }

        public void setMovies(List<Movie> movies) {
            this.movies = movies;
        }

        @NonNull
        @Override
        public String toString() {
            return "ResponseData{" +
                    "movieCount=" + movieCount +
                    ", limit=" + limit +
                    ", page_number=" + pageNum +
                    ", movies=" + movies +
                    '}';
        }
    }
}
