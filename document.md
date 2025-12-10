کلاس Car***
•	نگهداری شناسه‌ی ماشین (carId).
•	متدها:
o	سازنده
o	getCarId()

کلاس Node***
•	یک گره لیست پیوندی شامل:
o	شیء Car
o	اشاره‌گر به گره بعدی
•	متدها: سازنده‌ها، getCar, getNext, setNext

کلاس LinkedList***
•	لیست پیوندی تک ‌جهته با اشاره‌ گر به  head  و tail
•	متدها:
o	عملیات پایه‌ای : addFirst, addLast, removeFirst, first, isEmpty
o	مرتب‌سازی: mergeSort, merge 

کلاس Queue***
•	پیاده‌سازی صف با لیست پیوندی.
•	متدها:
o	enqueue
o	dequeue
o	first, size, isEmpty

کلاس Stack***
•	پیاده‌سازی پشته با لیست پیوندی.
•	ظرفیت محدود (m).
•	متدها:
o	push, pop, top
o	size, isEmpty
o	sortStack

کلاس Parking***
•	مدیریت کل پارکینگ شامل:
o	یک صف ورودی (entry)
o	چند پشته (stacks)
•	متدها:
o	entry(Car)
o	entry(Car, int num)
o	find(int carId)
o	exit(int carId)
o	sortStack(int i)
o	move(int i, int j)
o	printStack()

کلاس Project***
شامل متد main
o	مشخص شدن ظرفیت صف و پشته توسط کاربر
o	نمایش منو برای انتخاب عملیات توسط کاربر
o	نمایش پیغام خطا در صورت ورودی اشتباه
o	بعد از انتخاب گزینه عملیات مورد نظر با صدا زدن تابع ها انجام میشود

________________________________________
ارتباط بین کلاس‌ها
•	Car → داده اصلی 
•	Node → واحد لیست پیوندی
•	LinkedList → ساختار پایه
•	Queue و Stack → ساخته شده بر اساس LinkedList
•	Parking → ترکیب Queue و چند Stack برای شبیه‌سازی پارکینگ


لینک گیت هاب    https://github.com/narges1385/Data-Structure-Project
