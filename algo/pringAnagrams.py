data = list()

data.append('a')
data.append('b')
data.append('c')


def printAnagram(data, start, end, prefix):
	current = data[start]
	
	if start == end-1:
		print(prefix, current)
		return

        # Using backtracking algo here	
	for i in range(start,end):
		temp = data[i]
		data[i] = current
		printAnagram(data,start+1, end, prefix+temp)
		data[start] = current
		data[i]=temp


printAnagram(data,0,len(data), "")

