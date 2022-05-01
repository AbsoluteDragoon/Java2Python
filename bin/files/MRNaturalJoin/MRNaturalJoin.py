from mrjob.job import MRJob

class MRNaturalJoin(MRJob):        
        
    
    def mapper(self, _, line):
        if len(line.split(',')) == 4:
            name,did,age,major = line.split(',')
            yield did, [name, age, major]
        else:
            className,grade,did = line.split(',')
            yield did, [className,grade]
        
    def reducer(self, key, values):
        values = [x for x in values]
        if len(values) > 1:
            person = values[0]
            for value in values[1:]:
                yield key, [person, value]
        else:
            pass
        

if __name__ == '__main__':
    MRNaturalJoin.run()