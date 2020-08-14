package com.ssafy.hw.step09.console;

import java.util.ArrayList;

public interface INewsDAO {
	public ArrayList<News> getNewsList(String url);
	public News search(int index);
}