// --- The ULTIMATE Guardian 
#pragma once
// --- Libraries
#include <string>

// --- Skeleton
class Random{
// 	 --- Attributes --- 
	private:
		double doubleOne;
	public:
		int integerOne;
		int integerTwo;
		float floatOne;
		std::string string;
// 	 --- Constructors --- 
	public:
		Random(int,double,float){};
		Random(float){};
		Random(double){};
		Random(int){};
// 	 --- Methods --- 
	private:
		std::string Bye(){};
	public:
		void Hello(int){};
};
