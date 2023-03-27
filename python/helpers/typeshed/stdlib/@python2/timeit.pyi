from typing import IO, Any, Callable, Sequence, Text

_str = str | Text
_Timer = Callable[[], float]
_stmt = _str | Callable[[], Any]

default_timer: _Timer

class Timer:
    def __init__(self, stmt: _stmt = ..., setup: _stmt = ..., timer: _Timer = ...) -> None: ...
    def print_exc(self, file: IO[str] | None = ...) -> None: ...
    def timeit(self, number: int = ...) -> float: ...
    def repeat(self, repeat: int = ..., number: int = ...) -> list[float]: ...

def timeit(stmt: _stmt = ..., setup: _stmt = ..., timer: _Timer = ..., number: int = ...) -> float: ...
def repeat(stmt: _stmt = ..., setup: _stmt = ..., timer: _Timer = ..., repeat: int = ..., number: int = ...) -> list[float]: ...

_timerFunc = Callable[[], float]

def main(args: Sequence[str] | None = ..., *, _wrap_timer: Callable[[_timerFunc], _timerFunc] | None = ...) -> None: ...