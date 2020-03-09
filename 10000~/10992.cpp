#include <iostream>
using namespace std;

int main()
{
	int n;
	cin >> n;

	//뚜껑
	for (int j = 1; j <= n - 1; j++)
	{
		cout << " ";
	}
	cout << "*";
	cout << endl;

	//본체
	if (n > 1)
	{
		for (int i = 2; i <= n - 1; i++)
		{
			for (int j = i; j <= n - 1; j++)
			{
				cout << " ";
			}
			cout << "*";
			for (int j = 1; j <= i * 2 - 3; j++)
			{
				cout << " ";
			}
			cout << "*";
			cout << endl;
		}

		//바닥
		for (int j = 1; j <= n * 2 - 1; j++)
		{
			cout << "*";
		}

	}
}
