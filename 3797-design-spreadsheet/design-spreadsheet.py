class Spreadsheet:

    def __init__(self, rows: int) -> None:
        self.cells_data = {}
    
    def setCell(self, cell: str, value: int) -> None:
        self.cells_data[cell] = value
    
    def resetCell(self, cell: str) -> None:
        self.cells_data.pop(cell, None)
    
    def getValue(self, formula: str) -> int:
        result = 0
        terms = formula[1:].split('+')
        for term in terms:
            if term[0].isdigit():
                result += int(term)
            else:
                result += self.cells_data.get(term, 0)
        return result
        


# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)